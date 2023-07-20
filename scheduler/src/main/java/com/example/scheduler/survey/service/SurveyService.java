package com.example.scheduler.survey.service;


import com.example.scheduler.survey.repository.SurveyAnswerRepository;
import com.example.scheduler.survey.repository.SurveyRepository;
import com.example.scheduler.survey.repository.SurveyResultRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyAnswerRepository surveyAnswerRepository;
    private final SurveyResultRepository surveyResultRepository;
    
}
