#!/bin/bash


EXPECTED_ARGS=1

if [ $# -ne $EXPECTED_ARGS ]
then
  echo "Usage: `basename $0` [blang-dsl-version]"
  exit 1
fi

source script_utilities.sh

artifact_repo=~/artifacts/
project_repo=`pwd`
remote_repo='s2:~/public_html/maven/'

destination=$artifact_repo/blang-eclipse-plugin-$1

if [ -d $destination ]; then
    echo "Already published $destination"
    exit 1
fi

echo Local artifacts repo: $artifact_repo
echo Remote artifacts repo: $remote_repo

echo "Checking that the project git repo is up to date, at least locally.."
if ! is_git_clean
then
  echo "Make sure everything is committed in the project dir before releasing artifacts"
  exit 1
fi

mvn install
cp -r ca.ubc.stat.blang.repository/target/repository $destination

echo "Sending changes to server"
rsync -t --rsh=/usr/bin/ssh --recursive --perms --group $artifact_repo $remote_repo; echo "Finished pushing eclipse plug-in artifacts" &