package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Feedback;
import com.example.Repo.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(Long feedbackId, Feedback feedbackDetails) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow();
        feedback.setRating(feedbackDetails.getRating());
        feedback.setDescription(feedbackDetails.getDescription());
        feedback.setTimestamp(feedbackDetails.getTimestamp());
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}

