package lv3.베스트앨범

internal class Solution {

    // 필요한 것
    // 1. 들은 횟수 별로 정렬된 장르의 노래 번호
    // 2. 장르 별 재생 횟수
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        // 장르 별 노래 번호 테이블
        val genreWithMusicTable = genres.indices.groupBy { genres[it] }
        // 장르 별 재생 횟수
        val genreWithPlayedCount = genreWithMusicTable.entries.associate {
            it.key to it.value.fold(0) { total, next -> total + plays[next] }
        }.toList().sortedByDescending { it.second }
        // 장르 별 재생 횟수로 정렬된 노래 번호 리스트 (장르별 상위 2개 씩)
        val top2OfEachGenre = genreWithPlayedCount.map { (genre, _) ->
            genreWithMusicTable[genre]!!.sortedByDescending { plays[it] }.take(2)
        }

        return top2OfEachGenre.flatten().toIntArray()
    }
}