Build with
```
export GITHUB_ACTOR=<user>
export GITHUB_TOKEN=<token>
./gradlew build
```

Run with
```
./gradlew app:run --args="--input /home/gmodena/Downloads/dataset/wiki-news-300d-1M.vec --max-records 1000 --num-trees 3 --max-node-size 7 --num-results 20"
```
