#问题与处理方法
###1、mysql的root密码忘记了
#####(1)电脑中找到C:\Windows\System32\cmd.exe，右键->以管理员身份运行，便会弹出一个cmd窗口。
#####(2)检查mysql服务是否关闭，如果mysql服务已经关闭，则直接跳到(3);如未关闭，则在(1)中的cmd窗口输入`net stop mysql`以关闭mysqlf服务。
#####(3)继续在(1)中cmd窗口输入`mysqld --console --skip-grant-tables --shared-memory`,此时控制台会出现“...\bin\mysqld.exe: ready for connections.”等字眼。`2020-01-23T00:43:53.175130Z 0 [System] [MY-010931] [Server] D:\MySoftware\2DevEnvironment\mysql\mysql-8.0.17\bin\mysqld.exe: ready for connections. Version: '8.0.17'  socket: ''  port: 0  MySQL Community Server - GPL.`  此时保留这个cmd窗口，以下的操作均是在新的cmd窗口中完成。
#####(4)保留前面步骤的cmd窗口，电脑中找到C:\Windows\System32\cmd.exe，右键->以管理员身份运行，另开一个新的cmd窗口。注：此步骤做完应该存在两个cmd窗口，一个是执行过（3）中命令的，一个是全新的。
#####(5)在(4)中新开的cmd窗口直接输入`mysql`即可进入mysql服务。
#####(6)在(5)中的cmd窗口继续输入`use mysql`,使用mysql数据库。
#####(7)在(6)中的cmd窗口继续输入`flush privileges;`更新权限。
#####(8)在(7)中的cmd窗口继续输入`alter user 'root'@'localhost' identified by '这里改成自己的新密码';`修改密码。此时密码已经修改成功。
#####(9)把前面两个cmd窗口关闭，然后电脑中找到C:\Windows\System32\cmd.exe，右键->以管理员身份运行，执行`net start mysql`启动mysql服务即可。
                                                                           
###2、引用静态文件
##### 需要定位到resource目录下
`<link href="../../css/bootstrap.min.css" rel="stylesheet">`
`<script src="../../js/bootstrap.min.js"></script>`
