export VIP_SATURN_CONSOLE_URI=http://localhost:9092
cd saturn-executor-3.3.1/bin
#修改权限
chmod a+x saturn-executor.sh
#启动
./saturn-executor.sh start -n jobcenter.erp.wms -e executor_001