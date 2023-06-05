import type {SidebarConfig} from '@vuepress/theme-default'

export const sidebarZh: SidebarConfig = {
    '/course/': [
        {
            text: '基础课程',
            children: [
                '/course/readme.md',
                '/course/01/index.md',

            ],

        },
        {
            text: '课程拓展',
            children: [
                '/course/ext/git.md',
            ]
        }
    ]
}