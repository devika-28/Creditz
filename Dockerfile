# Filename: Dockerfile 
FROM node:10-alpine
WORKDIR ./src/app
COPY package*.json ./
#RUN npm cache verify
#RUN npm install -g parcel-bundler  
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
