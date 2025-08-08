export interface Policy {
  id?: number;               // optional
  quoteId: number;
  policyNumber?: string;     // optional
  startDate: string;
  endDate: string;
  totalPremium: number;
}
