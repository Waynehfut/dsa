#!/usr/bin/env bash
set -e
yarn build
cd docs/.vuepress/dist

git init
git add -A
git commit -m 'deploy'
git push -f https://${ACCESS_TOKEN}@github.com/waynehfut/dsa.git master:gh-pages

cd -

