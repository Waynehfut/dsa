module.exports = () => { //下述是目录
    return [
        '',//根目录
        '01/',//仅有index.md情况
        {//包含子目录情况
            title: '课程拓展',
            collapsable: true,
            children: [
                'ext/git',
            ]
        }
    ]
}