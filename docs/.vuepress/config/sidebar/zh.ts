import type {SidebarConfig} from '@vuepress/theme-default'

export const sidebarZh: SidebarConfig = {
    '/course/': [
        {
            text: '基础课程',
            children: [
                '/course/readme.md',
                '/course/01/index.md',
                '/course/02/index.md',
                '/course/03/index.md',
                '/course/04/index.md',

            ],

        },

    ],
    '/ext/':[//
        {
            text: '课程拓展',
            children: [
                '/ext/index.md',
                '/ext/debugWithSSH.md'
            ]
        }
    ]
}