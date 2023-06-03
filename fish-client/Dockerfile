FROM node:18-alpine

EXPOSE 3000

WORKDIR /client

COPY . /client/

RUN npm i --omit=dev

CMD ["npm", "start"]