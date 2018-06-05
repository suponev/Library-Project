// test
export interface Publication {
  text: string;
}

export interface PublicationRequest {
  text: string;
  image_id: string;
  username: string;
  user_id: number;
}

export interface PublicationResponse {
  image: string;
  text: string;
  image_id: string;
  username: string;
  user_id: number;
}

export interface PublicationFilter {
  count: number;
  date_time: string;
  raiting: number;
}
