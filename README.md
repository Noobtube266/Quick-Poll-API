# Quick-Poll-API
Post http://localhost:8080/polls
```{
"question" : "Who will win SuperBowl this year?",
"options" : [
              {"value" : "New England Patriots"},
              {"value" : "Seattle Seahawks"},
              {"value" : "Green Bay Packers"},
              {"value" : "Denver Broncos"}
             ]
}```
Get http://localhost:8080/polls
Put http://localhost:8080/polls/1
```{
"id" : 1,
"question" : "Who will win SuperBowl in 2015?",
"options" : [
              {"id": 1, value" : "New England Patriots"},
              {"id": 2, "value" : "Green Bay Packers"},
              {"id": 3, "value" : "Denver Broncos"},
              {"id": 4, "value" : "Seattle Seahawks"}
             ]
}```
Post http://localhost:8080/polls/1/votes
{
"option": {"id": 1, "value": "New England Patriots"}
}```
Get http://localhost:8080/computeresult?pollId=1
Get http://localhost:8080/polls/100
Post http://localhost:8080/polls
```{
"options" : [
              {"value" : "New England Patriots"},
              {"value" : "Seattle Seahawks"},
              {"value" : "Green Bay Packers"},
              {"value" : "Denver Broncos"}
            ]
}```
