// Generated by view binder compiler. Do not edit!
package com.example.cinema_magic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cinema_magic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MovieDetailsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button backButton;

  @NonNull
  public final TextView movieActors;

  @NonNull
  public final TextView movieCountry;

  @NonNull
  public final TextView movieDescription;

  @NonNull
  public final TextView movieDirector;

  @NonNull
  public final ImageView moviePosterImage;

  @NonNull
  public final TextView movieRating;

  @NonNull
  public final TextView movieReleasedYear;

  @NonNull
  public final TextView movieStudio;

  @NonNull
  public final TextView movieTitleDetail;

  @NonNull
  public final TextView titleTop;

  private MovieDetailsBinding(@NonNull LinearLayout rootView, @NonNull Button backButton,
      @NonNull TextView movieActors, @NonNull TextView movieCountry,
      @NonNull TextView movieDescription, @NonNull TextView movieDirector,
      @NonNull ImageView moviePosterImage, @NonNull TextView movieRating,
      @NonNull TextView movieReleasedYear, @NonNull TextView movieStudio,
      @NonNull TextView movieTitleDetail, @NonNull TextView titleTop) {
    this.rootView = rootView;
    this.backButton = backButton;
    this.movieActors = movieActors;
    this.movieCountry = movieCountry;
    this.movieDescription = movieDescription;
    this.movieDirector = movieDirector;
    this.moviePosterImage = moviePosterImage;
    this.movieRating = movieRating;
    this.movieReleasedYear = movieReleasedYear;
    this.movieStudio = movieStudio;
    this.movieTitleDetail = movieTitleDetail;
    this.titleTop = titleTop;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MovieDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MovieDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.movie_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MovieDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backButton;
      Button backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.movieActors;
      TextView movieActors = ViewBindings.findChildViewById(rootView, id);
      if (movieActors == null) {
        break missingId;
      }

      id = R.id.movieCountry;
      TextView movieCountry = ViewBindings.findChildViewById(rootView, id);
      if (movieCountry == null) {
        break missingId;
      }

      id = R.id.movieDescription;
      TextView movieDescription = ViewBindings.findChildViewById(rootView, id);
      if (movieDescription == null) {
        break missingId;
      }

      id = R.id.movieDirector;
      TextView movieDirector = ViewBindings.findChildViewById(rootView, id);
      if (movieDirector == null) {
        break missingId;
      }

      id = R.id.moviePosterImage;
      ImageView moviePosterImage = ViewBindings.findChildViewById(rootView, id);
      if (moviePosterImage == null) {
        break missingId;
      }

      id = R.id.movieRating;
      TextView movieRating = ViewBindings.findChildViewById(rootView, id);
      if (movieRating == null) {
        break missingId;
      }

      id = R.id.movieReleasedYear;
      TextView movieReleasedYear = ViewBindings.findChildViewById(rootView, id);
      if (movieReleasedYear == null) {
        break missingId;
      }

      id = R.id.movieStudio;
      TextView movieStudio = ViewBindings.findChildViewById(rootView, id);
      if (movieStudio == null) {
        break missingId;
      }

      id = R.id.movieTitleDetail;
      TextView movieTitleDetail = ViewBindings.findChildViewById(rootView, id);
      if (movieTitleDetail == null) {
        break missingId;
      }

      id = R.id.titleTop;
      TextView titleTop = ViewBindings.findChildViewById(rootView, id);
      if (titleTop == null) {
        break missingId;
      }

      return new MovieDetailsBinding((LinearLayout) rootView, backButton, movieActors, movieCountry,
          movieDescription, movieDirector, moviePosterImage, movieRating, movieReleasedYear,
          movieStudio, movieTitleDetail, titleTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
