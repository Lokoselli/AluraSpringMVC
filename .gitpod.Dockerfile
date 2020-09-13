FROM gitpod/workspace-mysql

USER root

RUN apt-get update && \
      apt-get -y install sudo
      
RUN sudo snap install --classic heroku
