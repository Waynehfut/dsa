import { defaultTheme } from "vuepress";
// @ts-ignore
import { mdEnhancePlugin } from "vuepress-plugin-md-enhance";
import { copyCodePlugin } from "vuepress-plugin-copy-code2";

import { navbarEn, navbarZh, sidebarEn, sidebarZh } from "./config/configBar";

export default {
  head: [["link", { rel: "icon", href: "/assets/img/logo.png" }]],
  locales: {
    //站点级别的多语言处理
    "/": {
      lang: "zh-CN",
      title: "数据结构与算法",
      description: "本站介绍了数据结构与算法课程的授课细节",
    },
    //有机会再整英文
    // '/en/': {
    //     lang: 'en-US',
    //     title: 'Data Structure and Algorithm',
    //     description: 'Introduction for Data Structure and Algorithm'
    // }
  },
  theme: defaultTheme({
    //主题配置
    // 默认主题配置
    logo: "/assets/img/logo.png",
    repo: "waynehfut/dsa",
    docsDir: "docs",
    locales: {
      "/": {
        navbar: navbarZh,
        selectLanguageName: "简体中文",
        selectLanguageText: "选择语言",
        selectLanguageAriaLabel: "选择语言",
        sidebar: sidebarZh,
        editLinkText: "在 GitHub 上完善此页",
        lastUpdatedText: "上次更新",
        contributorsText: "贡献者",
        tip: "提示",
        warning: "注意",
        danger: "警告",
        // 404 page
        notFound: [
          "这里什么都没有",
          "我们怎么到这来了？",
          "这是一个 404 页面",
          "看起来我们进入了错误的链接",
        ],
        backToHome: "返回首页",
        // a11y
        openInNewWindow: "在新窗口打开",
        toggleColorMode: "切换颜色模式",
        toggleSidebar: "切换侧边栏",
      },
      "/en/": {
        navbar: navbarEn,
        selectLanguageName: "English",
        sidebar: sidebarEn,
      },
    },
  }),
  plugins: [
    copyCodePlugin({
      showInMobile:false,
    }),
    mdEnhancePlugin({
      // 使用 KaTeX 启用 TeX 支持
      katex: true,
      figure: true,
      imgSize: true,
      container: true,
      echarts: true,
      footnote: true,
      // 启用图片懒加载
      imgLazyload: true,
      // 使用 mathjax 启用 TeX 支持
      mathjax: true,
      //代码块
      codetabs: true,
      mermaid: true,
      mark: true,
    }),
  ],
};
