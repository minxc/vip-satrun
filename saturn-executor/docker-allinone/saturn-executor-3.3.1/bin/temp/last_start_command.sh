#!/bin/bash
cd /home/ming/sygit/00/jobcenter/saturn-executor/docker-allinone/saturn-executor-3.3.1/bin
chmod +x ./saturn-executor.sh
./saturn-executor.sh start -n jobcenter.erp.wms -e executor_150 -d /home/ming/sygit/00/jobcenter/saturn-executor/docker-allinone/saturn-executor-3.3.1/app
