# :computer: 20分钟学会使用git

我将简单的把 Git 常用的过程记录一下，尽量不使用命令行等操作，涉及比较难理解的部分都略过，以供参考。

<!-- more -->

## 初始化本地环境

初始化本地环境，首先需要安装 Git 软件。
从[git-scm](https://git-scm.com/)下载对应平台安装包即可。

### 安装 Git

安装 Git-scm，只需要一步一步的傻瓜式下一步即可，注意要勾选加入 Path 的选项

### 填写配置文件

首次安装后，需要配置个人信息，以供远程仓库或者协作者识别你的个人信息(用户名和邮箱)。以我的为例：

```bash
git config --global user.name "Hao Wang"
git config --global user.email "waynehfut@outlook.com"
```

![git config](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203421.png)

之后云端及协作端都会以这样的信息来识别你。

### 配置 SSH 访问

需要注意的是，很多情况下我们用到的都是私有仓库，这时为了保证仓库不会被别人破坏，我们需要对访问者设置权限，此时，我们需要在本地生成唯一的识别码。

详细可参考[github](https://help.github.com/cn/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

1. 打开 shell(cmd)，执行 <注意替换自己的邮箱>

   ```shell
   ssh-keygen -t rsa -b 4096 -C "waynehfut@outlook.com"
   ```

   会出现这样的执行结果：

   ```shell
   > Generating public/private rsa key pair.
   > Enter a file in which to save the key (/c/Users/you/.ssh/id_rsa):[Press enter]
   > Enter passphrase (empty for no passphrase): [Type a passphrase]
   > Enter same passphrase again: [Type passphrase again]
   ```

   一般一路按 Enter 到底即可，当看到这个结果时，即表示生成成功
 
   ![ssh key](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203457.png)

2. 在远程代码仓库配置

   一般远程的代码仓库都支持 ssh，以 GitHub 为例，在[这个链接](https://github.com/settings/keys)中点击`New SSH key`；
   填写从`C:\Users\$yourname$\.ssh`下`id_rsa.pub`内的内容到 github 上

   ![add key](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203515.png)

3. 测试

   ```shell
   ssh -T git@github.com
   ```

   出现类似以下输出即表示添加成功

   ![test ssh](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203542.png)

## 与远程同步

我们使用 Git 一般有两种初始场景，一个是远程的代码直接拉下来，一个是本地代码想推出去。下面举例最简单的方法。

### 同步远程代码库

如果远程代码库已经设置好了，可以直接从 git clone 下来。以这个仓库为例：

1. 点击这个部分的按钮复制 ssh 路径

   ![copy ssh](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203602.png)

2. 在本地的 shell(cmd)打开并执行 git clone 命令

```shell
git clone git@github.com:Waynehfut/CNNDetectFramework.git
```

类似这样的结果，即表示拉取成功

![git cloned](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203619.png)

1. 我们在本地就会发现代码已经拉取下来（文件夹名称与项目同名）

### 本地创建代码库

1. 如果是本地创建项目，可以先在远程仓库创建一个空白仓库，直接新建即可：

![create repo](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203643.png)

1. 为方便起见，不要使用平台提供的任何文件，不使用 readme 初始化。

![create](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203704.png)

1. 初始化本地项目信息

在项目根目录下执行以下命令：

```shell
git init # 该步骤是指定当前文件夹为git仓库
git add -A # 该步骤是将所有文件设置为git追溯文件
git commit -m "first commit" # 提交当前状态到暂存，并填写信息为`first commit`
git remote add origin git@github.com:Waynehfut/test.git # 添加远程仓库
git push -u origin master # 将本地状态推送到远程仓库
```

4. 可能会觉得很麻烦，所有我们可以使用 vscode 或者 github desktop 等 GUI 工具实施上述操作，以 vscode 为例：

- 我们打开一个项目文件夹，并点击左侧的源代码管理按钮，我们可以看到很多待提交的更改（注意，该文件夹已经初始化了远程仓库）：

![project](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203728.png)

- 先填写 commit 信息，并点击“+”号暂存本地。

  效果等同于命令

  ```shell
  git add <file>
  ```

![add info](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203748.png)

- 点击提交，提交的待同步更改

  效果等同于命令

   ```shell
  git commit -m "message"
  ```

![commit](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203807.png)

- 同步仓库

  效果等同于命令

   ```shell
   git pull <remote-branch>
   git push <remote-branch> <local-branch>
   ```

![sync](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203827.png)

这样就可以提交代码到远程仓库

## 其他操作

还有一些其他操作需要了解

### .gitignore

有时我们的本地仓库有很多是不希望提交到远程的，甚至不想 git 来追踪它们，我们可以使用.gitignore 来屏蔽这些文件。

这里 [git ignore template](https://github.com/github/gitignore)有很多模板可以直接套用。

语法规则为：

```shell
*.txt # 屏蔽所有txt文件
/unsedfolder/ # 屏蔽名为unsedfolder的文件夹
```

### 回滚

有时，我们写代码会希望回到上一个状态，针对不同状态，有不同的做法：

1. 已提交 commit 未同步 push

   ```shell
   git reset HEAD <fileName> # 对<fileName>文件取消提交
   git checkout <fileName> # 对<filename>文件回退
   ```

2. 已同步 push
   一般情况下，我们每次的提交都会有 commit id, 我们可以使用这个 id 来回退到这状态，如图中的 commit 后的一长串字符就是 commitID

   ```shell
   git log # 显示所有log信息'
   git revert commitID #依据commitID回退
   ```

   ![gitlog](https://raw.githubusercontent.com/Waynehfut/blog/img/img/20201124203847.png)

### 分支

有时，我们希望多个分支来开发，一般会有 master 或 dev，细节部分请参考
[Git-分支-分支的新建与合并](https://git-scm.com/book/zh/v2/Git-%E5%88%86%E6%94%AF-%E5%88%86%E6%94%AF%E7%9A%84%E6%96%B0%E5%BB%BA%E4%B8%8E%E5%90%88%E5%B9%B6)

### 协作

你可以为你的仓库指定多个人管理，这样就有了协作问题，此时推荐使用 Gitlens 插件，以观察代码的修改过程。同时协作过程中会有代码冲突的可能，即你们同时修改了某个文件的某行，这样就会有冲突存在，大部分情况下 git 可以自行处理并合并，如果无法处理，一般会保留冲突部分，交由自己解决。

需要注意的是，防止冲突的关键是我们提交代码的顺序，我们**需要首先(commit),接着拉取代码(pull)**,冲突只可能在这个过程出现,注意解决它,接着再 push 即可。vscode 中将这个过程简化为了`同步（Ctrl+T）`。

### 私有仓库

Github 和 Gitlab 现在都支持私有仓库，所以如果不开源，建议设置私有仓库以保证数据安全。
