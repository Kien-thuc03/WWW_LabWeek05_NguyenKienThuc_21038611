package vn.edu.iuh.fit.labweek_05.fontend.controller;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.labweek_05.backend.models.*;
import vn.edu.iuh.fit.labweek_05.backend.services.AddressServices;
import vn.edu.iuh.fit.labweek_05.backend.services.CandidateServices;
import vn.edu.iuh.fit.labweek_05.backend.services.CompanyServices;
import vn.edu.iuh.fit.labweek_05.backend.services.JobServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private AddressServices addressServices;
    @Autowired
    private JobServices jobServices;
    @Autowired
    private CompanyServices companyServices;

    @RequestMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateServices.findAll());
        return "candidates/candidates";
    }

    @RequestMapping(value = "/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size,
                                          @RequestParam("keyword") Optional<String> keyword) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String searchKeyword  = keyword.orElse("");
        Page<Candidate> candidatePage = candidateServices.findAll(
                currentPage - 1, pageSize,searchKeyword  , "id", "asc");

        model.addAttribute("candidatePage", candidatePage);
        model.addAttribute("search", searchKeyword);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }



    @RequestMapping(value = "/add-candidate", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("countries", CountryCode.values());
        return "candidates/add-candidate";
    }

    @RequestMapping(value = "/add-candidate", method = RequestMethod.POST)
    public String add(Candidate candidate) {
        addressServices.save(candidate.getAddress());
        candidateServices.save(candidate);
        return "redirect:/candidates";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("countries", CountryCode.values());
        Candidate candidate = candidateServices.findById(id);
        model.addAttribute("candidate", candidate);
        return "candidates/update-candidates";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id, Candidate candidate) {
        candidate.setId(id);
        addressServices.save(candidate.getAddress());
        candidateServices.save(candidate);
        return "redirect:/candidates";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id, Model model) {
//        Candidate candidate = candidateServices.findById(id);
//        candidateServices.delete(candidate);
//        return "redirect:/candidates";
//    }


    @GetMapping("/candidates/{id}/suggested-skills")
    public String suggestSkills(@PathVariable Long id, Model model) {
        Candidate candidate = candidateServices.findById(id);
        List<JobSkill> allSkills = jobServices.findAllJob().stream()
                .flatMap(job -> job.getJobSkills().stream())
                .distinct()
                .toList();
        List<JobSkill> suggestedSkills = allSkills.stream()
                .filter(skill -> !candidate.getCandidateSkills().contains(skill))
                .collect(Collectors.toList());
        model.addAttribute("suggestedSkills", suggestedSkills);
        return "candidates/suggested-skills";
    }

    @GetMapping("/candidates/{id}/suggested-jobs")
    public String suggestJobs(@PathVariable Long id, Model model) {
        Candidate candidate = candidateServices.findById(id);
        List<Job> suggestedJobs = jobServices.suggestJobsForCandidate(id);

        model.addAttribute("candidate", candidate);
        model.addAttribute("suggestedJobs", suggestedJobs);

        return "candidates/suggested-jobs";
    }



    @GetMapping("/jobs/{id}/suggested-candidates")
    public String suggestCandidates(@PathVariable Long id, Model model) {
        Job job = jobServices.findById(id);
        List<Candidate> list = job.getJobSkills().stream()
                .map(jobSkill -> candidateServices.findCandidateBySkill(jobSkill.getSkill().getSkillName(), jobSkill.getSkillLevel()))
                .flatMap(List::stream)
                .distinct()
                .toList();
        model.addAttribute("suggestedCandidates", list);
        model.addAttribute("job", job);
        return "companies/candidates-suggested";
    }

    @RequestMapping(value = "/candidates/{jobId}/{companyId}/send-application-email", method = RequestMethod.GET)
    public String showApplicationEmailForm(@PathVariable("jobId") Long jobId,
                                           @PathVariable("companyId") Long companyId,
                                           Model model) {
        Job job = jobServices.findById(jobId);
        Company company = companyServices.findById(companyId);
        model.addAttribute("job", job);
        model.addAttribute("company", company);
        return "jobs/send-application-email"; // Giao diện form
    }

    @RequestMapping(value = "/candidates/send-application-email", method = RequestMethod.POST)
    public String sendApplicationEmail(@RequestParam("jobId") Long jobId,
                                       @RequestParam("companyId") Long companyId,
                                       @RequestParam("subject") String subject,
                                       @RequestParam("emailBody") String emailBody) {
        Job job = jobServices.findById(jobId);
        Company company = companyServices.findById(companyId);
        jobServices.sendEmailApply(job, company, subject, emailBody);
        return "redirect:/companies"; // Điều hướng về danh sách công ty
    }



}
