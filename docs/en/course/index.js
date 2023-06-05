module.exports = () => { //下述是目录
    return [
        'chap1',//根目录
        {//包含子目录情况
            title: 'Course extensions',
            collapsable: true,
            children: [
                'chap1',
            ]
        }
    ]
}