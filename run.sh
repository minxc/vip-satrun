#!/usr/bin/env bash

# ./gradlew :clean
# ./gradlew :bootJar


appName='jobcenter_saturn_console'

harborServer='harbor.34580.com'
harborUser='0000516'
harborPwd='Windows2000'

jarName="saturn-console-3.3.1-exec.jar"

#cp  build/libs/ ./
app_version=`git rev-list --count HEAD`

dockerImageTag=${harborServer}/erp/${appName}/${appName}:${app_version}

echo ${dockerImageTag}

docker build -f dockerfile-saturn-console --build-arg JAR_FILE=${jarName} -t ${dockerImageTag} .


     echo 'Docker push'
docker login -u ${harborUser} -p ${harborPwd} ${harborServer}
docker push ${dockerImageTag}
docker logout ${harborServer}

echo 'k8s Replace'
  # dockerImageTagForK8s= ${dockerImageTag}.replaceAll('/','\\\\/')
 sed -i 's#@{dockerImageTag}#'$dockerImageTag'#g' k8s.yaml
 sed -i 's#@{appName}#'${appName}'#g' k8s.yaml
#kubectl apply -f k8s.yaml


#//((ParameterizedType)(TypeToken.of(daoClass.getGenericInterfaces()[0]).getType())).getActualTypeArguments()
# TypeToken.of(UserDao.class).resolveType(type).getType() //type 为 method.getGenericReturnType()