# :ledger: 预备课 准备工作

本章节主要说明的是在开始学习之前的基本准备工作，虽然我们认为在开始学习这门课之前，你应该掌握了基本的计算机导论的相关内容，但是为了更进一步的
降低这门课程的学习门槛，我们将以Java语言为例对部分内容做简单的说明，并补充一定的C/C++的语言内容。

## IDE配置

本课程推荐使用[Jetbrains系列的IDE](https://www.jetbrains.com/)或者[Visual Studio Code](https://code.visualstudio.com/)
来编写代码。前者具有较好的开箱即用能力，后者则更具有灵活性，可按需配置。

### Jetbrains系列

1. 前往Jetbrains官网下载安装[toolbox](https://www.jetbrains.com/toolbox-app/)(推荐，便于后期更新IDE)
   ![Jetbrain Toolbox](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306040911069.png)
   ![安装](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306040914227.png)
2. 启动后安装Intellij IDEA(Java)或CLion(C/C++)等对应语言的IDE即可

   ![启动](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306040916938.png)

::: note
这里以Java为例
:::

4. 以IDEA为例，安装完成后即可在开始菜单找到，点击打开，首次使用可以不导入设置

   ![不导入设置](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306040919417.png)
4. 如果下载了Ultimate版本，则需要登录账号验证权限，这里我们推荐使用教育网邮箱注册，可以免费试用，具体细节
   [参见此处](https://www.jetbrains.com.cn/community/education/#students)
5. 登录完成后，即可来到主页面，点击New Project，选择New Project.

   ![主页面](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306040921172.png)
6. 如果没有配置JDK的话，我们可以看到JDK部分是*No SDK*的，选择*Download JDK*，之后创建项目即可

   ![下载JDK](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051008262.png)

   以OpenJDK 20为例

   ![下载JDK2](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051041701.png)
7. 之后便可运行Hello World程序

   ![Hello World](https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051043239.png)

[//]: # (   ![Hello World]&#40;https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051043239.png&#41;)

### Visual Studio Code

当然我们可以选择无需订阅的VS Code

1. 前往官网下载[VS Code](https://code.visualstudio.com/)
2. 安装后新建文件（如：hello.java）

   <img alt="hello" src="https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051119670.png"/>

3. 按提示安装Java环境

   <img alt="安装Java环境"  src="https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051122507.png"/>
   <img alt="安装JDK"  src="https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051126818.png"/>

4. 安装完成后运行代码验证是否成功

   <img alt="VS Code验证"  src="https://cdn.jsdelivr.net/gh/waynehfut/img@img/img/202306051131938.png"/>

::: note
借助插件，VS Code还可以实现很多强大的功能，参见[插件市场](https://marketplace.visualstudio.com/vscode)。
:::

## Git使用

此外，我们经常会遇到代码需要保存或者修改版本的情况，这里拓展介绍一下Git的使用

参见[20分钟Git基础操作](../ext/index.md)

            