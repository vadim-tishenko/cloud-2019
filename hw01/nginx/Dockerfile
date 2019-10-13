FROM alpine:3.10
RUN apk update && apk upgrade
RUN apk add nginx
RUN mkdir -p /run/nginx
COPY default.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

