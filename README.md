# ww1346的物流信息系统大作业

## 项目结构

本项目采用了时下流行的前后端分离技术，前端采用vue进行开发，后端采用了spring boot技术框架，整合了swagger2和Mybatis-plus技术。

## 快速部署

如果你是新手，请按如下步骤进行项目的部署

### 环境安装

#### JAVA环境安装

本项目基于JDK1.8开发，请确保安装了java环境，可以通过在CMD中输入

```
java -version
```

查看当前安装的Java版本

#### MySQL5.7安装

本项目的数据库采用了MySQL，使用的版本是5.7。当然如果使用了8.0的版本也可以正常运行，但需在项目的src->main->resources->application.yml里调整连接属性，同样的，如果需要使用自己的数据库也可到这里进行调整。至于MySQL的安装本教程不做详细说明，可自行搜索资料安装配置。

#### Maven配置

如果你曾经使用过基于Spring Boot的项目，则可以跳过这步，否则请检查自己的Maven环境是否已经配置。这里建议国内用户将仓库换成国内的镜像，如阿里云的镜像，或者直接下载需要的依赖到本地仓库。

#### Node.js的安装

在node.js的[官网](https://nodejs.org/en/)下载![image-20210507094710036](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507094710036.png)

然后自行安装完毕后打开安装目录，在命令行运行如下两个命令（路径换为node安装路径）：

```
npm config set prefix "D:\nodejs\node_global"
npm config set cache "D:\nodejs\node_cache"
```

到这里npm和node的配置就完成了

#### VUE的安装

具体安装步骤查看[官方文档](https://cn.vuejs.org/v2/guide/installation.html#NPM)

当你完成了如上步骤，基本的环境配置就大体完成了，请前往[这里](https://github.com/ww1346never996/hmsystembackend)下载后端源码，[这里](https://github.com/ww1346never996/hmsystemfrontend)下载前端源码，并在后端源码中导入SQL文件到数据库，完成部署前的一切准备。

### 项目部署

当你完成了两部分的项目源码下载，就可以开始项目的部署测试了。下面我将用IDEA和WebStorm演示如何导入：

![image-20210507105303149](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507105303149.png)

点击Open or Import，选择我们的后端项目

![image-20210507105412349](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507105412349.png)

找到项目下的pom.xml文件，选择Reimport进行依赖的安装。

![image-20210507105514507](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507105514507.png)

点击右上角的运行按钮，即可运行后端程序

![image-20210507105614481](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507105614481.png)



打开任意浏览器，打开[此链接](localhost:8081/doc.html)，如果成功显示为接口文档，恭喜你，后端程序部署成功！

打开WebStorm，点击Open

![image-20210507110352133](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507110352133.png)

选择我们的前端源码，打开

右上角选择edit configurations

![image-20210507110556292](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507110556292.png)

配置如下

![image-20210507110624256](https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/image-20210507110624256.png)

点击绿色运行按钮，在运行后端程序的同时，打开浏览器访问[此链接](localhost:8080)，如果进入登录页面，恭喜你，项目已经成功部署！enjoy it！