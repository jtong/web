1. 安装Mysql，不要给root设置密码，安装jdk 1.6，安装gradle，把gradle设置为可以在命令行下执行，在命令行下执行下列命令
2. mysql -uroot
3. GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION; 
4. FLUSH PRIVILEGES;
5. gradle flywayMigrate -Dflyway.schemas=user_management_test -i
6. gradle flywayMigrate -i
7. mysql -Duser_management -uroot < core/src/main/resources/db/seed/init-user.sql
8. gradle jettyRun