package com.example.seiya.dentalclinic.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.seiya.dentalclinic.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesOffered extends AppCompatActivity {

    List<ServicesDetails> sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_offered);

        sdt = new ArrayList<>();
        sdt.add(new ServicesDetails("Dental Checkup", "In addition to daily brushing and flossing, you can help protect your oral health by seeing your dentist regularly for checkups. It's recommended that most people get a dental checkup every six months, but your dentist may recommend more frequent or fewer visits, depending on your dental health history.",R.drawable.cu));
        sdt.add(new ServicesDetails("Oral Prophylaxis"," cleaning of the teeth by a dentist or dental hygienist, including removal of plaque, materia alba, calculus, and extrinsic stains; done as a preventive measure for control of gingivitis.",R.drawable.phrophy));
        sdt.add(new ServicesDetails("Tooth Restoration", "A dental restoration or dental filling a treatment to restore the function, integrity, and morphology of missing tooth structure resulting from caries or external trauma as well as to the replacement of such structure supported by dental implants.",R.drawable.rest));
        sdt.add(new ServicesDetails("Tooth Extraction","A dental extraction (also referred to as tooth extraction, exodontia, exodontics, or informally, tooth pulling) is the removal of teeth from the dental alveolus (socket) in the alveolar bone. Extractions are performed for a wide variety of reasons, but most commonly to remove teeth which have become unrestorable through tooth decay, periodontal disease or dental trauma, especially when they are associated with toothache. Sometimes wisdom teeth are impacted (stuck and unable to grow normally into the mouth) and may cause recurrent infections of the gum (pericoronitis). In orthodontics if the teeth are crowded, sound teeth may be extracted (often bicuspids) to create space so the rest of the teeth can be straightened.",R.drawable.extract));
        sdt.add(new ServicesDetails("Prosthodontics","Prosthodontics, also known as dental prosthetics or prosthetic dentistry, is the area of dentistry that focuses on dental prostheses. ",R.drawable.pros));
        sdt.add(new ServicesDetails("Orthodontics","Orthodontia, also called orthodontics and dentofacial orthopedics, is a specialty field of dentistry that deals primarily with malpositioned teeth and the jaws: their diagnosis, prevention and correction. An orthodontist is a specialist who has undergone special training in a dental school or college after they have graduated in dentistry.",R.drawable.ortho));
        sdt.add(new ServicesDetails("Root Canal Treatment", "Root canal treatment is an often straightforward procedure to relieve dental pain and save your teeth. Patients typically need a root canal when there is inflammation or infection in the roots of a tooth. During root canal treatment, an endodontist who specializes in such treatment carefully removes the pulp inside the tooth, cleans, disinfects and shapes the root canals, and places a filling to seal the space.",R.drawable.rcanal));
        sdt.add(new ServicesDetails("Odontectomy","It is a procedure wherein the dentist will remove the tooth by seperating and opening the gums, sometimes there is the necessity to remove bone around the tooth. This is especially common ti the third molar teeth due to the fact that most of the third molars are impacted(embedded under the jaw bone).",R.drawable.odon));


        RecyclerView myreclerview = findViewById(R.id.servereycle);
        ServeOffRecyclerAdapter adapter = new ServeOffRecyclerAdapter(this,sdt);
        myreclerview.setLayoutManager(new GridLayoutManager(this, 2));
        myreclerview.setAdapter(adapter);
    }
}
