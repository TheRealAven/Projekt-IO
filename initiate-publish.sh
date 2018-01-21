if [ "$TRAVIS_BRANCH" == "master" ];then
echo -e "Publishing javadoc...\n"

cp -R doc/ $HOME/javadoc-latest
cp -R target/utility $HOME/dist-latest

# Get to the Travis build directory, configure git and clone the repo
cd $HOME
git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"
git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/TheRealAven/Projekt-IO gh-pages > /dev/null

echo -e "Commiting... \n"
# Commit and Push the Changes
cd gh-pages
git rm -rf ./javadoc
cp -Rf $HOME/javadoc-latest ./javadoc
git rm -rf ./dist
cp -Rf $HOME/dist-latest ./dist
git add -f .
git commit -m "Lastest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
git push -fq origin gh-pages > /dev/null

echo -e "Published Javadoc to gh-pages.\n"
fi