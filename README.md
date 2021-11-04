![](https://img-blog.csdnimg.cn/202110141506310.png)

前端时间使用Flutter，iOS，Android三种技术编写了三个相同功能的计算器APP，[github地址](https://github.com/ThinkerJack/android-ios-flutter_calculator)，https://github.com/ThinkerJack/android-ios-flutter_notepad。

# ios_calculator

## 1.项目简介

使用Swift编写的IOS APP，实现了计算器的常见功能。

## 2.环境简介

语言：Swift 5.4

UI框架：UIKit

包管理工具：CocoaPods

布局框架：SnapKit 5.0.0

## 3.项目截图

![](https://img-blog.csdnimg.cn/img_convert/d9cf4a90e8f9e659fa7cf93ea5e01626.png)

## 4.开发流程与代码逻辑简述

- 打开Xcode创建IOS APP项目。
- 引入包管理工具和框架。
- 编写布局类，继承UIView。编写Button组件，继承UIButton。
- 封装计算逻辑工具类。
- 在ViewController中引入布局文件，通过布局类中的按钮点击协议完成计算器的计算逻辑。

## 5.技术准备

- [Swift基础语法](https://docs.swift.org/swift-book/GuidedTour/GuidedTour.html)

- [UIKit使用](https://developer.apple.com/documentation/uikit/)

- [SnapKit使用](http://snapkit.io/docs/)

- [CocoaPods使用](https://cocoapods.org/)

  ```
  sudo gem install cocoapods
  pod init
  pod install
  ```

  M1 mac安装有[问题](https://github.com/CocoaPods/CocoaPods/issues/10723)

- [Swift中的协议](https://docs.swift.org/swift-book/LanguageGuide/Protocols.html)

## 6.总结

学习IOS开发也有一段时间了，学习途径包括哔哩哔哩视频教程，YouTube视频教程，Apple官网文档，阅读相关书籍。因为拥有Flutter和Android的开发经验，学习过程中没有什么大的阻碍，唯一觉得不好的一点是中文社区的匮乏，面向初学者的文章和书籍都比较少，随着IOS相关技术的破坏性更新，导致很多教程不适用，耽误了不少时间。编写UI有拖拽storyboard和纯代码两种方式，个人还是比较喜欢纯代码的方式。开发语言有Swift,objective-c，UI框架有UIkit和SwiftUI，选择了资料比较多的SWift和UIkit学习，技术选择的多样性在最初也造成了一些困惑，因为精力有限，不可能全都学。后续使用IOS技术写一些复杂点的APP，提升技术水平。



# android_calculator

## 1.项目简介

使用java编写的Android APP，实现了计算器的常见功能。

## 2.环境简介

语言：java 1.8

依赖库：详见android_calculator/app/build.gradle下的dependencies

## 3.项目截图

![](https://img-blog.csdnimg.cn/030dc2799f8b4d9cb0bc7d985ddc01bd.png)

## 4.开发流程与代码逻辑简述

- 编写布局xml，使用`constraintlayout`布局
- `activity`中注册控件，监听点击事件
- 点击=号时执行计算逻辑

## 5.技术准备

- java基础语法
- [安卓开发官网](https://developer.android.com/)
- [`constraintlayout`布局](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)

## 6.总结

三种技术写一个项目，感觉给自己挖了一大坑，本意是熟悉一下学习过的技术，可能最近工作和学习的状态都有所下滑，感觉没有什么动力了。

写之前看了一下其他的开源项目，参考了一下布局，学习了[`constraintlayout`布局](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)，其实本来想用jetpack试一下，不过自己kotlin还没学，而且学到太多也有点记不住，就放弃了。

可能需要歇一歇再继续。

# flutter_calculator

## 1.项目简介

使用dart编写的Flutter APP，实现了计算器的常见功能。

## 2.环境简介

语言：Dart 2.14

框架版本：Flutter stable, 2.0.6

## 3.项目截图

![](https://img-blog.csdnimg.cn/a018be470fdd4144ab85897ccfb0bc4c.png)

## 4.开发流程与代码逻辑简述

- Gridview和Expanded实现布局

## 5.技术准备

- Dart语法
- FLutter基础

## 6.总结

编程其实是一种思想的表达手段，某一天我突发奇想，想做一个什么样的APP，基于这个想法就有了客户端的页面，也是基于这个想法有了后端的业务。编程只不过是实现这个想法的工具，编程和程序员，就像文字和作家，画笔和画家之间的关系，重要的不是实现想法的手段，重要的是心，一个充满了想法的心灵才是最宝贵的。作家什么都不想写，文字对他有什么用呢，画家什么都不想画，画笔又有什么用呢，这样才能准确的理解编程的作用，如果没有一个改变世界的想法，google搜索和苹果手机也都不会出现了，拉里佩奇或乔布斯代码写的多好都没用。由此可见，互联网行业大部分的行业都是为了想法在服务，不管是产品，运营，UI，都是为了让想法变成现实，什么时候自己能成为不再为别人的想法服务的人，而是提出想法呢？有点跑题了。

android/iOS/flutter 三种技术写同一种APP本意是为了熟悉一下近来学习的android和iOS，flutter算是添头，写一下玩一玩。不过通过这次项目的编写，让我觉得其实很多的技术都是在做类似的事情，变化的只不过是API。用Icon，用RN，用FLutter，用Android，用IOS都可以写出APP来，成为大前端，也就是掌握多种可以做同一个事情的技术，会一种和会多种只不过是谁记住了更多的API。

最近在做一个移动端即时通讯的需求，读了一些技术博客，这些博客不是为了Flutter而写，他讲述的是客户端和服务器端整个的处理即时通讯的流程，客户端开启连接，心跳检测，创建本地数据库，服务端接收到消息再转发到客户端，等等。这让我觉得在业务开发上重要的其实不是语言或者技术，而是这种整体的，解决问题的思路，思路才是灵魂，语言和框架只不过是实现这种思路的工具。

工作已经两年了，感觉自己就是个API boy，掌握了很多的API，前端，客户端，服务端都写过，学过的语言都有七种了，以至于现在不是工作用到的技术，很多细节都想不起来了。可是这些API有多少是可以迁移的呢，过了几年有了新的语言，新的框架，所谓的编程经验也跟着清零。基于这种考虑，让我想到去学习计算机基础，学一学经久不衰的计算机科学，不能满足于学习API。从技术投资的角度来讲，肯定是希望自己学习的技术永远不过时，现在来看只有计算机科学有这样的特性，准备学一学试一试。当我认识到我可能会从事十几年的计算机行业后，我觉得不能再为了面试而学习了，应该学一些真正的可以贯穿整个职业生涯的知识。

从资本的角度出发，不管跨平台写出来的APP有多烂，跨平台还是提高了员工生产力。从我自己的角度出发，我觉得跨平台也是一种很好的技术方案，本来都是做的类似的事情，何必要用那么多种语言，那么多种框架，当Flutter web正式版出了之后，我就放弃了JS技术栈的学习，学习多种技术做同一种东西在我看来毫无意义。即使FLutter不是终极方案，我觉得跨端是不会消失的，只要还有各种各样的端存在，跨端技术就会存在。

我觉得一名好的跨端工程师不只是掌握跨端技术，能够写端上的应用，也应该熟悉端的特性，能够解决对应端的特定问题。自己未来一年里，除去基础知识的学习外，也会朝着这个目标前进。未来的一年内，也会寻找机会为开源社区做出贡献。技术在我这里分两种，一种是应该学的技术，所谓应该学的技术就是市场需要什么样的技术人才，对应的就是就是应该学的技术。另一种是感兴趣的技术，感兴趣的技术就全凭自己的心意，想学点什么就学点什么。

这两年来多半是在学应该学的技术，很多想做的事情，感兴趣的技术都被排在后面了，现在想一想如果当初不是对Flutter产生了兴趣，自己也不会在这两年里取得这么大的进步。其实做正确的事情我只是全凭意志力在坚持，而做感兴趣的东西会让我感到快乐和兴奋，生活已经够艰难了，还是应该让自己快乐一些，接下来一两年的时间里，我决定多学习一些自己感兴趣的知识，做自己真正想做的事情。做正确的事情，取得世俗意义上的成功，对自己来说毫无意义。做自己想做的事情，成为自己想成为的人，才是最有意义的事情。人生还长着呢，如果这一两年发现做自己感兴趣的东西完全行不通，到时候再调整方向也来得及。

我虽然希望一年后的自己成功，但我更希望一年后的自己快乐。人生一辈子都追求正确，虽然能有一个好的结果，但是也会错过一些其他的风景，我决定去看看这些风景。

“我支持你，加油！”

![](https://img-blog.csdnimg.cn/c66cc07b674c424ba11ec6825e22a640.png)

![](https://img-blog.csdnimg.cn/46f9ed15f914479ab130d47e9578e721.png)
