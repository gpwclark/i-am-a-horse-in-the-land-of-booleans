FROM clojure
MAINTAINER gpwclark

# install necessary programs
RUN apt-get update && apt-get install -y \
  git \
  wget \
  vim \
  tmux \
  libssl-dev \
  curl \
  ca-certificates \
  wamerican 

# Make non sudo user and copy code from git repo to the docker image
RUN useradd -ms /bin/bash user
RUN mkdir -p /home/user/app
WORKDIR /home/user/app
ADD . /home/user/app
COPY project.clj /home/user/app/
RUN lein deps
COPY . /home/user/app/
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

# set up environment for development
WORKDIR /home/user
RUN wget https://raw.githubusercontent.com/gpwclark/System-files/master/.vimrc
RUN wget https://raw.githubusercontent.com/gpwclark/System-files/master/.tmux.conf
RUN wget https://raw.githubusercontent.com/gpwclark/System-files/master/.bashrc
WORKDIR /home/user/app
RUN mkdir -p /home/user/.vim
RUN git clone https://github.com/VundleVim/Vundle.vim.git /home/user/.vim/bundle/Vundle.vim

# Housekeeping
RUN chown -R user:user /home/user
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

USER user
