const cnJavaDsaIndex = require('../course')
module.exports = {
    themeConfig: {
        logo: '/assets/img/logo.png',
        repo: 'waynehfut/dsa',
        repoLabel: '查看源码',
        editLinks: true,
        docsBranch: 'main',
        docsDir: 'docs',
        editLinkText: '在Github上改善此页面！',
        displayAllHeaders: true,
        locales: {
            '/': {
                label: '简体中文',
                selectText: '选择语言',
                ariaLabel: '选择语言',
                nav: [ //顶部导航栏
                    {text: '主页', link: '/'},
                    {text: '课程', link: '/course/'},
                ],
                // sidebar: {
                //     '/course/': ['', 'chap1','ext/git'],//课程列表
                // },
                sidebar: {
                    // '/course/': cnJavaDsaIndex()
                    '/course/': ['', '01/chap1','ext/git']
                },
            },
            '/en/': {
                label: 'English',
                selectText: 'Languages',
                ariaLabel: 'Select language',
                nav: [ //顶部导航栏
                    {text: 'Home', link: '/en/'},
                    {text: 'course', link: '/en/course/'},
                ],
                sidebar: {
                    '/en/course/': ['', 'chap1'],//课程列表
                },
            }
        }
    },
    locales: { //多语言处理
        '/': {
            lang: 'zh-CN',
            title: '数据结构与算法',
            description: '本站介绍了数据结构与算法课程的授课细节'

        },
        '/en/': {
            lang: 'en-US',
            title: 'Data Structure and Algorithm',
            description: 'Introduction for Data Structure and Algorithm'
        }
    }
}

