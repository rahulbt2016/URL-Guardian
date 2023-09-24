interface AnalysisResults {
  category: string;
  result: string;
  method: string;
  engine_name: string;
}

interface Tracker {
  url: string;
  timestamp: number;
  id: string;
}

interface HttpResponseHeaders {
  [key: string]: string;
}

interface Categories {
  [key: string]: string;
}

interface LastAnalysisStats {
  harmless: number;
  malicious: number;
  suspicious: number;
  undetected: number;
  timeout: number;
}

interface UrlAnalysisResponse {
  data: {
      attributes: {
          total_votes: {
              harmless: number;
              malicious: number;
              suspicious: number;
              undetected: number;
              timeout: number;
          };
          last_modification_date: number;
          times_submitted: number;
          threat_names: string[];
          redirection_chain: string[];
          last_analysis_results: {
              [key: string]: AnalysisResults;
          };
          last_submission_date: number;
          last_http_response_content_length: number;
          last_http_response_headers: HttpResponseHeaders;
          reputation: number;
          tags: string[];
          last_analysis_date: number;
          first_submission_date: number;
          categories: Categories;
          last_http_response_content_sha256: string;
          last_http_response_code: number;
          last_final_url: string;
          trackers: {
              [key: string]: Tracker[] | null;
          };
          url: string;
          title: string;
          tld: string;
          last_analysis_stats: LastAnalysisStats;
          outgoing_links: string[];
          html_meta: any; // You can specify the actual type for html_meta if known.
      };
      type: string;
      id: string;
      links: {
          self: string;
      };
  };
}

export interface IUrlReport {
  canRedirect: boolean;
  maliciousVotes: number;
  suspiciousVotes: number;
  vendorNameMalicious: string[];
  vendorNameSuspicious: string[];
  trackers: string[];
  urlAnalysisResponse: UrlAnalysisResponse;
}

