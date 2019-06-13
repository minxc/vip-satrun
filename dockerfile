FROM openjdk:11-jdk-oracle

ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8
ENV TZ='Asia/Shanghai'
# Add Tini
ENV TINI_VERSION v0.18.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini

#RUN yum install -y openssh-clients

WORKDIR /opt/app

ARG JAR_FILE

#COPY ${JAR_FILE}  .

COPY build/libs .

RUN echo "jar-->"${JAR_FILE}

EXPOSE 9098

#ENV jarPath=${JAR_FILE}

# java,product environment and other
ENV JAVA_CMD="/usr/bin/java -jar  -XX:-OmitStackTraceInFastThrow -Dserver.port=9098 -Dauthentication.enabled=true -Dauthorization.enabled.default=true ${JAR_FILE}  "
ENV JAVA_CMD_PRO="/usr/bin/java  -jar  -XX:-OmitStackTraceInFastThrow  -Dserver.port=9098 -Dauthentication.enabled=true -Dauthorization.enabled.default=true  ${JAR_FILE}  "

ENTRYPOINT ["/tini", "--", "/bin/sh", "-c", "if [ ${SPRING_PROFILES_ACTIVE} = 'pro' ] ; then $JAVA_CMD_PRO ;else $JAVA_CMD ;fi"]


#ENTRYPOINT ["/bin/sh", "-c", "/usr/bin/java -jar  $jarPath","" ]
