export interface Response<T> {
  codeStatus: string,
  messageInfo: string,
  data: T
}
