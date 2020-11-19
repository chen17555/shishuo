package com.chenzhiheng.TestMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.chenzhiheng.mapper.TagMapper;
import com.chenzhiheng.model.Tag;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTagMapper {

    @Autowired
    TagMapper tagMapper;

    @Test
    public void testInsertData(){
        final Integer SOFTWARE_NUM = 100;
        //计算机系标签  100
        String[]   tags = {"Android","AngularJS","Bootstrap","C","C#","C++","Cocos2d-x","CSS3","Go","Html/CSS","Html5","iOS","JAVA","JavaScript",
        "JQuery","Linux","Maya","MongoDB","Mysql","Node.js","Oracle","Photoshop","PHP","Premiere","Python","React.JS","Ruby","Sass/Less","SQL Server",
        "Unity 3D","Vue.js","WebApp","ZBrush","云计算","前端工具","大数据","数据结构","机器学习","测试","深度学习"};

        String[] desc={"Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。尚未有统一中文名称，中国大陆地区较多人使用“安卓”或“安致”。Android操作系统最初由Andy Rubin开发，主要支持手机。",
        "AngularJS是一款优秀的前端JS框架，已经被用于Google的多款产品当中，核心特点是MVVM、模块化、自动化双向数据绑定、语义化标签、依赖注入，等等",
        "Bootstrap是Twitter推出的一个开源的用于前端开发的工具包。它由Twitter的设计师Mark Otto和Jacob Thornton合作开发，是一个CSS/HTML框架。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成",
        "C，一种通用的、过程式的编程语言，广泛用于系统与应用软件的开发。",
        "C#是微软公司发布的一种面向对象的、运行于.NET Framework之上的高级程序设计语言。",
        "C++是在C语言的基础上开发的一种通用编程语言，应用广泛。C++支持多种编程范式——面向对象编程、泛型编程和过程化编程。",
        "Cocos2d-x提供的框架。手机游戏，可以写在C++或者Lua中，使用API是Cocos2d-iPhone完全兼容。",
        "CSS即层叠样式表（Cascading StyleSheet）。 在网页制作时采用层叠样式表技术，可以有效地对页面的布局、字体、颜色、背景和其它效果实现更加精确的控制",
        "Go语言专门针对多处理器系统应用程序的编程进行了优化，使用Go编译的程序可以媲美C或C++代码的速度，而且更加安全、支持并行进程。",
        "html是HyperText Mark-up Language的简称，即超文本标记语言，css是英文Cascading Style Sheets的缩写；html主要承载网页内容如文字、图片、视频等。CSS则控制网页显示的样式如颜色、字体、大小等；HTML/CSS是网页前端开发的基础，几乎所有web开发都需要掌握此技术。",
        "HTML5它的综合性功能可助网页设计者和开发者们一臂之力，使他们在开发新一代线上应用程序时能够得心应手。HTML5其它令人赞不绝口的产品特色能还包括：离线功能，即用户可以在没有连接网络的状态下，仍可与网络程序进行互动；以及拖拽功能，同网络本身一样，HTML5也基于用户的需求和开发者的构想而处于不断进化的过程之中。作为一个开放式标准，HTML5体现出网络最为杰出的特点：它随时随地均可运作，或者说，它在任何装有现代浏览器的设备上都能大放异彩。",
        "iOS与苹果的Mac OS X操作系统一样，它也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。",
        "JAVA 是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun公司于1995年5月推出的Java程序设计语言和Java平台（即JavaEE, JavaME, JavaSE）的总称。Java自面世后就非常流行，发展迅速。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，拥有全球最大的开发者专业社群，同时也是进行Android开发的必备基础。",
        "JavaScript做为Web前端开发师需要掌握的必杀技术，它是互联网最流行的脚本语言。为数百万计的网页添加炫酷动态效果和友好的用户交互行为，如想您想提供漂亮的网页、令用户满意的上网体验，JavaScript是必不可少的。同时所有主流浏览器都支持JavaScript，编程环境简单，很容易使用！",
        "JQuery是继prototype之后又一个优秀的Javascript框架。它是轻量级的js库 ，它兼容CSS3，还兼容各种浏览器，jQuery2.0及后续版本将不再支持IE6/7/8浏览器。jQuery使用户能更方便地处理HTML（标准通用标记语言下的一个应用）、events、实现动画效果，并且方便地为网站提供AJAX交互。jQuery还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。",
        "Linux是一套免费使用和自由传播的类Unix操作系统，是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统",
        "Autodesk Maya是美国Autodesk公司出品的世界顶级的三维动画软件，应用对象是专业的影视广告，角色动画，电影特技等。Maya功能完善，工作灵活，易学易用，制作效率极高，渲染真实感极强，是电影级别的高端制作软件。",
        "Mongo DB是目前在IT行业非常流行的一种非关系型数据库，其灵活的数据存储方式，备受当前IT从业人员的青睐，随着互联网网站的兴起，NoSQL在国内掀起一阵热潮，其中风头最劲的莫过于Mongo DB。对于大数据量、高并发、弱事务的互联网应用，MongoDB可以应对自如。越来越多的业界公司已经将MongoDB投入实际的生产环境，很多创业团队也将MongoDB作为自己的首选数据库，创造出非常之多的移动互联网应用。",
        "Mysql是最流行的关系型数据库管理系统，在WEB应用方面MySQL是最好的RDBMS(Relational Database Management System：关系数据库管理系统)应用软件之一。",
        "Node.js是一个服务器端 JavaScript 解释器，它将改变服务器应该如何工作的概念。它的目标是帮助程序员构建高度可伸缩的应用程序，编写能够处理数万条同时连接到一个（只有一个）物理机的连接代码。Node.js是一个基于Chrome JavaScript 运行时建立的一个平台，用来方便地搭建快速的易于扩展的网络应用。Node.js借助事件驱动，非阻塞I/O 模型变得轻量和高效，非常适合运行在分布式设备的数据密集型的实时应用。它是一个可以快速构建网络服务及应用的平台。",
        "Oracle是在数据库领域一直处于领先地位的产品。可以说Oracle数据库系统是目前世界上最流行的关系数据库管理系统，系统可移植性好、使用方便、功能强，适用于各类大、中、小、微机环境。",
        "Adobe Photoshop，简称“PS”，是由Adobe Systems开发和发行的图像处理软件。Photoshop主要处理以像素所构成的数字图像。使用其众多的编修与绘图工具，可以有效地进行图片编辑工作。ps有很多功能，在图像、图形、文字、视频、出版等各方面都有涉及。",
        "PHP一种被广泛应用的开放源代码的多用途脚本语言，和其他技术相比，php本身开源免费； 可以将程序嵌入于HTML中去执行， 执行效率比完全生成htmL标记的CGI要高许多，它运行在服务器端，消耗的系统资源相当少，具有跨平台强、效率高的特性，而且php支持几乎所有流行的数据库以及操作系统，最重要的是PHP还可以用C、C 进行程序的扩展，PHP语言在WEB开发方面有着非常广泛的应用，除此之外，PHP4，PHP5中，面向对象有了很大的改进，还可以用来开发大型商业程序。",
        "一款常用的视频编辑软件，由Adobe公司推出。现在常用的有CS4 CS5 CS6等版本。是一款编辑画面质量比较好的软件，有较好的兼容性，且可以与adobe公司推出的其他软件相互协作。目前这款软件广泛应用于广告制作和电视节目制作中。",
        "Python是一种面向对象、解释型计算机程序设计语言；Python语法简洁而清晰，具有丰富和强大的类库。它常被昵称为胶水语言，能够把用其他语言制作的各种模块（尤其是C/C ）很轻松地联结在一起",
        "React.JS是Facebook开发的一款JS库",
        "适用所有的 web开发和 服务器后端开发人员. Ruby 不需要编译, 可以直接运行, 是脚本语言. 具备最强大的元编程, 函数式编程能力, 同时, 面向对象的特别彻底.",
        "Sass/Less 是一种 “CSS 预处理器”技术，什么是 CSS 预处理器？这被叫做\"CSS预处理器\"（css preprocessor）。它的基本思想是，用一种专门的编程语言，进行网页样式设计，然后再编译成正常的CSS文件。",
        "SQL Server 是Microsoft 公司推出的关系型数据库管理系统。",
        "Unity是由Unity Technologies开发的一个让玩家轻松创建诸如三维视频游戏、建筑可视化、实时三维动画等类型互动内容的多平台的综合型游戏开发工具，是一个全面整合的专业游戏引擎",
        "Vue.js 是用于构建交互式的 Web 界面的库。它提供了 MVVM 数据绑定和一个可组合的组件系统，具有简单、灵活的 API。从技术上讲， Vue.js 集中在 MVVM 模式上的视图模型层，并通过双向数据绑定连接视图和模型。实际的 DOM 操作和输出格式被抽象出来成指令和过滤器。相比其它的 MVVM 框架，Vue.js 更容易上手。",
        "WebApp是指基于Web的系统和应用，其作用是向广大的最终用户发布一组复杂的内容和功能",
        "ZBrush软件是一个数字雕刻与绘画软件，主要用于影视，游戏等复杂数字模型的雕刻与绘制，它将三维动画中最耗费精力的角色建模和贴图工作，变成了小朋友玩泥巴那样的简单有趣！如今已成为专业动画制作领域里面最重要的建模主流软件！",
        "云计算是基于互联网的相关服务的增加、使用和交付模式，通常涉及通过互联网来提供动态易扩展且经常是虚拟化的资源",
        "web前端开发时使用的相关工具",
        "大数据(big data,mega data)，或称巨量资料，指的是需要新处理模式才能具有更强的决策力、洞察力和流程优化能力的海量、高增长率和多样化的信息资产。",
        "数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。",
        "",
        "软件测试，是指对各类程序进行操作，以发现程序错误，衡量程序质量，并对其是否能满足设计要求进行评估的过程。",
        ""};

        String[] img={"59e96f7a0001117402400240","59e96ed90001e4e702400240","59e96ecc0001850802400240","59e96e980001d29602400240","59e96e2900010d7d02400240",
        "59e96e7800018e5502400240","59e96e560001cb2902400240","59e96ebe0001a9ad02400240","59e96e6c0001108502400240","59e96ff90001ab0402400240","59e96f4f0001379302400240",
        "59e96f0a0001f87902400240","59e9700900012e3602400240","59e96f340001faac02400240","59e96f420001726302400240","59e96ef70001954402400240","59e96fe20001da2602400240",
        "59e96fd30001e6e502400240","59f2cdc30001916a02400240","59e96f5d00011f3602400240","59e96e890001d79b02400240","59e96fab0001534402400240","59e970190001280402400240",
        "59e96fbe000168f102400240","59e96f1c0001942802400240","59e96e0d0001a63a02400240","59e96dc70001bc0b02400240","59e96dd80001be3802400240","59e96e370001ac0202400240",
        "59e96e6300011c3502400240","59e96deb0001f9d302400240","59e96ea50001e08602400240","59e96e1f000178aa02400240","59e96ee90001485b02400240","59e96eb100019d5902400240",
        "59e96e4a0001989102400240","59e96db800015f3902400240","59e9995c0001a39f02400240","59e96df800014e9902400240","59e999680001a39f02400240"};

        for(int i = 0;i < tags.length;i++){
            Tag tag = new Tag();
            tag.setTagId(SOFTWARE_NUM + i);
            tag.setTagName(tags[i]);
            tag.setTagDesc(desc[i]);
            tag.setTagImg("/static/img/tag/" + img[i] + ".jpg");
            tag.setUpdateTime(new Date());
            tagMapper.insert(tag);
        }

    }

}
