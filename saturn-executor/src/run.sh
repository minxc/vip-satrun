sleep 11


# start executor
chmod +x /apphome/saturn-executor-3.3.1/bin/saturn-executor.sh
/apphome/saturn-executor-3.3.1/bin/saturn-executor.sh start -n jobcenter.erp.wms -r foreground -jmx 8080