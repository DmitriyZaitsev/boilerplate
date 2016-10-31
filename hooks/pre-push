#!/bin/bash

read -p "You're about to push, are you sure you won't break the build? " -n 1 -r < /dev/tty
echo
if [[ $REPLY =~ ^[Yy]$ ]]
then
    exit 0 # push will execute
fi
exit 1 # push will not execute