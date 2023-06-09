import type {SidebarConfig} from '@vuepress/theme-default'

export const sidebarEn: SidebarConfig = {
    '/en/course/': [
        {
            text: 'Basic Course',
            children: [
                '/en/course/01/index.md',
            ],

        },
        {
            text: 'Course Extension',
            children: [
                '/en/course/ext/index.md',
            ]
        }
    ]
}