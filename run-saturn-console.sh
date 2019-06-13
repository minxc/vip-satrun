java -Dserver.port=9098 \
-DVIP_SATURN_CONSOLE_CLUSTER=jobcenter01 \
-DSATURN_CONSOLE_DB_URL=jdbc:mysql://10.1.62.230:3306/saturn \
-Dauthentication.enabled=true \
-Dauthorization.enabled.default=true \
-DSATURN_CONSOLE_DB_USERNAME=root -DSATURN_CONSOLE_DB_PASSWORD=Windows2000! \
-jar saturn-console-3.3.1-exec.jar 