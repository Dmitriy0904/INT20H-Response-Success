FROM node:18.14.0

WORKDIR /usr/src/app/angular

RUN npm install -g @angular/cli@13.2.6

COPY . /usr/src/app/angular

CMD ng serve --host 0.0.0.0 --port 4200