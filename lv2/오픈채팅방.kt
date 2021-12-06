class Solution {
    fun solution(recordArray: Array<String>): Array<String> {
        
        // 1. 입력된 record를 userMap과 userInOutList에 나누어 저장
        // userMap: key->uid, value-> nickname (uid를 기준으로 마지막꺼로 저장)
        // userInOutList : [${uid}, "행동"]
        // 2. userInOutList를 순서대로 읽어오되, uid는 userMap에서 최종 닉네임으로 변환
        
        // 1
        val userMap = mutableMapOf<String,String>()
        val userInOutList = mutableListOf<List<String>>()
        for(record in recordArray){
            val _record = record.split(" ")
            if(_record[0] == "Enter"){
                userInOutList.add(listOf(_record[1],"Enter"))
                userMap.put(_record[1],_record[2])
            }else if(_record[0] == "Leave"){
                userInOutList.add(listOf(_record[1],"Leave"))
            }else if(_record[0] == "Change"){
                userInOutList.add(listOf(_record[1],"Change"))
                userMap.put(_record[1],_record[2])
            }
        }
        
        // // for test
        // val numbers = mutableListOf(listOf(1,2),listOf(2,3),listOf(3,4))
        // println(numbers.mapNotNull { if ( it[0] == 2) null else 0 })
        
        // 2
        return userInOutList.mapNotNull{
            when(it[1]){
                "Enter" -> "${userMap.get(it[0])}님이 들어왔습니다."
                "Leave" -> "${userMap.get(it[0])}님이 나갔습니다."
                else -> null
            }
        }.toTypedArray()
    }
}
