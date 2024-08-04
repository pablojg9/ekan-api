package br.com.ekan.avaliacao.ekan.controller.beneficiary;

import br.com.ekan.avaliacao.ekan.controller.CrudController;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryRequestRecord;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryResponseRecord;
import br.com.ekan.avaliacao.ekan.service.CrudService;
import br.com.ekan.avaliacao.ekan.service.beneficiary.BeneficiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/beneficiarys")
@RequiredArgsConstructor
public class BeneficiaryController extends CrudController<BeneficiaryResponseRecord, BeneficiaryRequestRecord, UUID> {

  private final BeneficiaryService beneficiaryService;

  @Override
  protected CrudService<BeneficiaryResponseRecord, BeneficiaryRequestRecord, UUID> getService() {
    return beneficiaryService;
  }
}
