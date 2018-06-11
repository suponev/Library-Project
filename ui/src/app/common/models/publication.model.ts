// test
export interface Publication {
  text: string;
}

export interface PublicationRequest {
  text: string;
  image_base_64: string;
  user_id: number;
}

export interface PublicationResponse {
  publication_id;
  text: string;
  image_id: number;
  user_id: number;

  rating: number;
  yourRating: number;
}

export interface PublicationFilter {
  count: number;
  start_time: string;
  last_id: number;

}

export interface Vote {
  user_id: number;
  publication_id: string;
  vote: number;
}

