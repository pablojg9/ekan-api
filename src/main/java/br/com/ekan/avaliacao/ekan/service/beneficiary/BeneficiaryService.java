package br.com.ekan.avaliacao.ekan.service.beneficiary;

import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryRequestRecord;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryResponseRecord;
import br.com.ekan.avaliacao.ekan.service.CrudService;

import java.util.UUID;

public interface BeneficiaryService extends CrudService<BeneficiaryResponseRecord, BeneficiaryRequestRecord, UUID> {
}
