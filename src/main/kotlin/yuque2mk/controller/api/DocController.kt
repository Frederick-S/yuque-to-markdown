package yuque2mk.controller.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import yuque2mk.service.YuqueService
import yuque2mk.dto.Doc
import yuque2mk.dto.DocDetail
import javax.servlet.http.HttpSession

@RestController
class DocController : BaseApiController() {
    @Autowired
    private lateinit var yuqueService: YuqueService

    @GetMapping("/repos/{repoId}/docs")
    fun getDocs(@PathVariable repoId: Long, @RequestParam(required = false) offset: Int?, @RequestParam(required = false) limit: Int?, httpSession: HttpSession): List<Doc> {
        return yuqueService.getDocs(repoId, offset, limit, httpSession.getAttribute("accessToken").toString())
    }

    @GetMapping("/repos/{repoId}/docs/{docId}")
    fun getDocDetail(@PathVariable repoId: Long, @PathVariable docId: String, httpSession: HttpSession): DocDetail {
        return yuqueService.getDocDetail(repoId, docId, httpSession.getAttribute("accessToken").toString())
    }
}
