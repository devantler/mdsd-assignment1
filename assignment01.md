---
title: MDSD Assignment 01 - Internal DSL
author: Nikolai Emil Damm
date: 11-02-2022
...

# My solution

I solved the assignment so all tests passed. I did so by focusing on one test at a time, starting with the trivial stuff. I then implemented logic to make that test go green, and continued on to the next test. If a test went from green to red with new changes I would revisit it to make it go green again.

For the 'States' I created an 'ArrayList' and for the 'Integers' i created a 'HashMap'. For 'Operations' and 'Conditions' I created two separate folders, each with an abstract super class for the different types of operations/conditions, and then a class for each specific type.

# Location of repository and report

My code and this report is available in <https://github.com/devantler/mdsd-assignment1>. (I will make it public on the hand-in date, so others cannot cheat. If you need access before, please send me an email on <nidam16@student.sdu.dk>).
