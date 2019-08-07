export VIP_SATURN_CONSOLE_URI=http://10.1.62.170:19991
cd docker-allinone/saturn-executor-3.3.1/bin
#修改权限
chmod a+x saturn-executor.sh
#启动
./saturn-executor.sh start -n jobcenter.erp.wms -e executor_150 -d /home/ming/sygit/00/jobcenter/saturn-executor/docker-allinone/saturn-executor-3.3.1/app 