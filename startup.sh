#!/bin/bash

function starting_Rank () {
    cd target
    if [ -f "Ranking-SNAPSHOT.jar" ]; then
        echo -e "\nStarting Rank, please wait!"
        java -jar Ranking-SNAPSHOT.jar
    else
        echo -e "\nRanking-SNAPSHOT is not available. Please rebuild.\n"
    fi
}

if [ -d "target" ]; then
    echo -e "\ntarget folder is available!"
    read -p "Do you want to rebuild (y/n)?" YorN
    if [ "$YorN" = "y" ]; then
        echo -e "\nBuilding Maven Project! Please wait. \n"
        mvn clean install -q
        if [ "$?" -eq 0 ]; then
            starting_Rank
        else
            echo -e "\nBuild Failed! Please check and run startup script again. \n"
            exit 0
        fi
    elif [ "$YorN" = "n" ]; then
        starting_Rank
    else
        echo -e "\nPlease provide valid input. \n"
        exit 0
    fi
else
    echo -e "\nBuilding Maven Project! Please wait. \n"
    mvn clean install -q
    if [ "$?" -eq 0 ]; then
        starting_Rank
    else
        echo -e "\nBuild Failed! Please check and run startup script again. \n"
        exit 0
    fi
fi