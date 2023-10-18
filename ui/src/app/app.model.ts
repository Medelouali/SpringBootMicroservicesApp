

export interface Fraud{
    title: string;
    isFlagged: boolean;
    text: string;
    id: number;
}

export const fraudData: Fraud[] = [
    {
      title: "Unauthorized Credit Card Usage",
      isFlagged: true,
      text: "A credit card was used for unauthorized transactions.",
      id: 1,
    },
    {
      title: "Identity Theft",
      isFlagged: true,
      text: "Identity theft reported with personal information stolen.",
      id: 2,
    },
    {
      title: "Phishing Scam",
      isFlagged: false,
      text: "Received an email with a suspicious link.",
      id: 3,
    },
    {
      title: "Payment Fraud",
      isFlagged: true,
      text: "Received a fraudulent payment request.",
      id: 4,
    },
  ];
  

  