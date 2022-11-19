import { User } from './user';

export class Message {
  id?: number;
  identifier?: string;
  description?: string;
  // reference?: string;
  status?: number;
  createdBy?: User;
  resolvedBy?: User;
  verifiedBy?: User;
  createdAt?: number;
  updatedAt?: number;
  enabled?: boolean;
  voided?: boolean
}
