FROM gitpod/workspace-mysql

USER root

RUN apt-get update && \
      apt-get -y install sudo
      
RUN curl https://cli-assets.heroku.com/install.sh | sh
